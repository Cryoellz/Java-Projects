CREATE DATABASE IF NOT EXISTS oop_project;
USE oop_project;

CREATE TABLE IF NOT EXISTS employee (
  emp_id VARCHAR(30) PRIMARY KEY, seq INT AUTO_INCREMENT UNIQUE,
  last_name VARCHAR(50), first_name VARCHAR(50), middle_name VARCHAR(50),
  birth_date DATE, gender VARCHAR(10), position VARCHAR(50), department VARCHAR(50),
  date_hired DATE, salary DECIMAL(10,2), contact_no VARCHAR(20), address VARCHAR(150));

CREATE TABLE IF NOT EXISTS student (
  student_id VARCHAR(30) PRIMARY KEY, seq INT AUTO_INCREMENT UNIQUE,
  last_name VARCHAR(50), first_name VARCHAR(50), middle_name VARCHAR(50),
  birth_date DATE, gender VARCHAR(10), course VARCHAR(50), year_level VARCHAR(10),
  section VARCHAR(10), email VARCHAR(100), contact_no VARCHAR(20), address VARCHAR(150));

CREATE TABLE IF NOT EXISTS product (
  item_code VARCHAR(30) PRIMARY KEY, seq INT AUTO_INCREMENT UNIQUE,
  description VARCHAR(100), category VARCHAR(50), unit VARCHAR(20),
  unit_price DECIMAL(10,2), quantity INT, reorder_level INT, supplier VARCHAR(100));

CREATE TABLE IF NOT EXISTS book (
  book_id VARCHAR(30) PRIMARY KEY, seq INT AUTO_INCREMENT UNIQUE,
  isbn VARCHAR(20), title VARCHAR(150), author VARCHAR(100), publisher VARCHAR(100),
  year_published INT, category VARCHAR(50), edition VARCHAR(20), copies INT);

CREATE TABLE IF NOT EXISTS patient (
  patient_id VARCHAR(30) PRIMARY KEY, seq INT AUTO_INCREMENT UNIQUE,
  last_name VARCHAR(50), first_name VARCHAR(50), middle_name VARCHAR(50),
  birth_date DATE, gender VARCHAR(10), blood_type VARCHAR(5), contact_no VARCHAR(20),
  address VARCHAR(150), guardian VARCHAR(100), date_admitted DATE, diagnosis VARCHAR(200));
  
INSERT IGNORE INTO employee (emp_id, last_name, first_name) VALUES ('EMP-0023-PH', 'Seed', 'Row');