#!/usr/bin/perl
###
# (c) Comarch
###

#to be used with cwm.properties in same dir.
#should be reusable

use utf8;
use diagnostics -trace;
use strict;
use warnings FATAL => 'all';
use DBI;

my $props = undef;
my $file = 'cwm.properties';
my $file_log = 'cwm_init_log.log';
open(my $fh, '<:encoding(UTF-8)', $file)
  or die "Could not open properties file '$file' $!";
 
open(my $fh_out, '>', $file_log);
binmode STDOUT, ':utf8';
binmode $fh_out, ':utf8';
binmode (STDIN, ":encoding(utf8)"); 
 
 
while (my $row = <$fh>) {
  chomp $row;
  if (length($row) > 0) {
	my ($key,$value) = split /=/, $row;
	$props->{$key} = $value;
  }
}
close $fh;
die "Could not read db connection props" unless defined $props->{'liferay.db.conn.string'} &&
												defined $props->{'liferay.db.user'} &&
												defined $props->{'liferay.db.passwd'};
												
												
												
$props->{'liferay.db.conn.string'} =~ m/jdbc:postgresql:\/\/(\d+.\d+\.\d+\.\d+):(\d+)\/(\w+)/;
my ($host,$port,$db) = ($1,$2,$3);
my $dbh = DBI->connect('dbi:Pg:dbname='.$db.';host='.$host.';port='.$port, $props->{'liferay.db.user'}, $props->{'liferay.db.passwd'},
		{ RaiseError => 1, AutoCommit => 1, pg_enable_utf8 => 1})
		or die("Database connection not made: \n" );

sub do_sql($$){
	my ($dbh, $sql) = @_;
	my $sth = $dbh->prepare($sql);
	my $res = $sth->execute();
	if ($res != 0){
		my @ref = @{$sth->fetchall_arrayref( { Slice => {} })};
		return @ref;
	}
}

sub table_exists($$$){
	my ($table_name, $table_schema, $dbh) = @_;
	my $sql = "SELECT 1
				FROM information_schema.tables
				WHERE
				  table_schema = '$table_schema' AND
				  table_name = '$table_name'
				  AND table_type = 'BASE TABLE';";
	return do_sql($dbh, $sql);
};

sub constraint_exists($$$$){
	my ($constraint_name, $table_name, $constraint_schema, $dbh) = @_;
	my $sql = "SELECT 1 WHERE EXISTS(SELECT 1 FROM information_schema.table_constraints
		WHERE table_name = '$table_name' AND constraint_name = '$constraint_name' AND constraint_schema = '$constraint_schema');";
	return do_sql($dbh, $sql);
};

sub sequence_exists($$$){
	my ($sequence_name, $sequence_schema, $dbh) = @_;
	my $sql = "SELECT 1 WHERE EXISTS(SELECT 1 FROM information_schema.sequences WHERE sequence_name = '$sequence_name' AND sequence_schema = '$sequence_schema');";
	return do_sql($dbh, $sql);
};

sub column_exists($$$$){
	my ($column_name, $table_name, $table_schema, $dbh) = @_;
	my $sql = "SELECT 1 FROM information_schema.columns WHERE table_name = '$table_name' AND column_name = '$column_name' AND table_schema = '$table_schema';";
	return do_sql($dbh, $sql);
};

sub schema_exists($$){
	my ($schema_name, $dbh) = @_;
	my $sql = "SELECT 1 FROM information_schema.schemata WHERE schema_name = '$schema_name';";
	return do_sql($dbh, $sql);
}

sub index_exists($$$) {
	my ($index_name, $schema_name, $dbh) = @_;
	my $sql = "SELECT 1 FROM pg_class c, pg_namespace n WHERE c.relnamespace = n.oid AND relname = '$index_name' AND nspname = '$schema_name' AND relkind = 'i';";
	return do_sql($dbh, $sql);
}

my $ddl_dmls = ();
my $create_chosen_table = "CREATE TABLE rent.device_feature(
	id serial NOT NULL,
	name character varying(100),
	CONSTRAINT device_feature_id PRIMARY KEY (id)
	
);";
push @$ddl_dmls, $create_chosen_table unless table_exists('device_feature', 'rent', $dbh);

print $fh_out "\n\n------DMLS TO BE EXECUTED------\n\n";
foreach my $dml (@$ddl_dmls){
        print $fh_out $dml . "\n";
}
close $fh_out;
print "\n Check cwm_init_log.log for details. Continue [y/n]? \n";
my $input = <STDIN>;
chomp $input;
if ($input eq 'y' || $input eq 'Y'){
	my $dml_string = scalar @$ddl_dmls > 0 ? join " \n ", @$ddl_dmls : undef;
	my $result = $dml_string ? do_sql($dbh, $dml_string) : undef;
}
$dbh->disconnect();
