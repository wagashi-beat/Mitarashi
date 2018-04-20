set names utf8;
set foreign_key_checks= 0;
drop database if exists mitarashi;

create database if not exists mitarashi;
use mitarashi;


-- 会員情報テーブル --
drop table if exists user_info;

create table user_info (
id int not null primary key auto_increment,
user_id varchar(16) unique,
password varchar(16) not null,
family_name varchar(32) not null,
first_name varchar(32) not null,
family_name_kana varchar(32) not null,
first_name_kana varchar(32) not null,
sex tinyint default 0 not null,
birth_day varchar(8) not null,
email varchar(32) not null,
status tinyint default 0 not null,
logined tinyint default 0 not null,
regist_date datetime,
update_date datetime
);


-- カテゴリマスタテーブル --
drop table if exists m_category;

create table m_category (
id int not null primary key auto_increment,
category_id int unique not null,
category_name varchar(50) not null unique,
regist_date datetime,
update_date datetime
);


-- 会社マスタテーブル --
drop table if exists m_company;

create table m_company (
id int not null primary key auto_increment,
release_company_id int unique not null,
release_compary_name varchar(50) not null unique,
regist_date datetime,
update_date datetime
);


-- 商品情報テーブル --
drop table if exists product_info;

create table product_info (
id int not null primary key auto_increment,
product_id int not null unique,
product_name varchar(100) not null,
product_name_kana varchar(100) not null,
product_description varchar(255) not null,
price int not null,
category_id int not null,
release_company_id int not null,
image_file_path varchar(100) not null,
image_file_name varchar(50) not null,
release_date varchar(16) not null,
status tinyint default 0 not null,
regist_date datetime not null,
update_date datetime
);


-- カート情報テーブル --
drop table if exists cart_info;

create table cart_info (
id int not null primary key auto_increment,
user_id varchar(16) unique,
product_id int not null,
product_count int not null,
price int not null,
total_price int not null,
regist_date datetime not null,
update_date datetime
);


-- 宛先情報テーブル --
drop table if exists destination_info;

create table destination_info (
id int not null primary key auto_increment,
user_id varchar(16) not null unique,
family_name varchar(32) not null,
first_name varchar(32) not null,
family_name_kana varchar(32) not null,
first_name_kana varchar(32) not null,
email varchar(32) not null,
tel_number varchar(13) not null,
post_number varchar(7) not null,
user_address varchar(50) not null,
regist_date datetime not null,
update_date datetime
);


-- 購入履歴情報テーブル --
drop table if exists purchase_history_info;

create table purchase_history_info (
id int not null primary key auto_increment,
user_id varchar(16) not null unique,
product_id int not null,
product_count int not null,
price int not null,
total_price int not null,
image_file_path varchar(100) not null,
image_file_name varchar(50) not null,
family_name varchar(32) not null,
first_name varchar(32) not null,
user_address varchar(50) not null,
resist_date datetime not null,
status tinyint default 0 not null
);



-- user_infoテスト --
INSERT INTO user_info VALUES (
				1,
				"taro",
				"123",
				"山田",
				"太郎",
				"やまだ",
				"たろう",
				0,
				"19500401",
				"taro@yahoo.com",
				1,
				1,
				"2018/04/01",
				"2018/04/20"
);
