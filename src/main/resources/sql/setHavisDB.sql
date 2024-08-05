create user if not exists 'havis'@'%' identified by 'havis';
create database if not exists havisdb;
grant all privileges  on menudb.* to 'havis'@'%';