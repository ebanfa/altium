DROP TABLE IF EXISTS pricingoptions;
DROP TABLE IF EXISTS message;
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS assignment;
DROP TABLE IF EXISTS writingstyle;
DROP TABLE IF EXISTS urgency;
DROP TABLE IF EXISTS subject;
DROP TABLE IF EXISTS subjecttype;
DROP TABLE IF EXISTS subjectcategory;
DROP TABLE IF EXISTS documenttype;
DROP TABLE IF EXISTS academiclevel;
DROP TABLE IF EXISTS password;
DROP TABLE IF EXISTS signup;
DROP TABLE IF EXISTS login;
DROP TABLE IF EXISTS conversationmessagefile;
DROP TABLE IF EXISTS conversationmessage;
DROP TABLE IF EXISTS conversationparty;
DROP TABLE IF EXISTS conversation;
DROP TABLE IF EXISTS conversationtype;
DROP TABLE IF EXISTS conversationcategory;
DROP TABLE IF EXISTS partyprofile;
DROP TABLE IF EXISTS classifiedfile;
DROP TABLE IF EXISTS fileclassification;
DROP TABLE IF EXISTS fileclassificationtype;
DROP TABLE IF EXISTS file;
DROP TABLE IF EXISTS filetype;
DROP TABLE IF EXISTS filecategory;
DROP TABLE IF EXISTS accounttransaction;
DROP TABLE IF EXISTS accounttransactionstatus;
DROP TABLE IF EXISTS accounttransactiontype;
DROP TABLE IF EXISTS billingaccount;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS partygroup;
DROP TABLE IF EXISTS partyrole;
DROP TABLE IF EXISTS roletype;
DROP TABLE IF EXISTS party;
DROP TABLE IF EXISTS partytype;
DROP TABLE IF EXISTS partycategory;
DROP TABLE IF EXISTS business;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS locationtype;
DROP TABLE IF EXISTS currency;
DROP TABLE IF EXISTS classification;
DROP TABLE IF EXISTS classificationtype;


CREATE TABLE classificationtype  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE classification  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NULL,
   	class_type   int(11) NOT NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
 	FOREIGN KEY (class_type) REFERENCES classificationtype (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE currency  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
	symbol   		varchar(75) NOT NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE locationtype  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE location  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
   	location_type   int(11) NOT NULL,
   	parent_location   int(11) NULL,
   	location_currency   int(11) NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
 	FOREIGN KEY (location_type) REFERENCES locationtype (id), 
 	FOREIGN KEY (parent_location) REFERENCES location (id), 
 	FOREIGN KEY (location_currency) REFERENCES currency (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE business  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
   	currency   int(11) NOT NULL,
   	business_location   int(11) NOT NULL,
	user_name   		varchar(75) NOT NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
 	FOREIGN KEY (currency) REFERENCES currency (id), 
 	FOREIGN KEY (business_location) REFERENCES location (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE partycategory  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE partytype  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NULL,
   	party_category   int(11) NOT NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
 	FOREIGN KEY (party_category) REFERENCES partycategory (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE party  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
   	party_type   int(11) NOT NULL,
	name   varchar(75) NOT NULL,
	user_name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
 	FOREIGN KEY (party_type) REFERENCES partytype (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE roletype  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE partyrole  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NULL,
   	party_role_party   int(11) NOT NULL,
   	RoleType   int(11) NOT NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
 	FOREIGN KEY (party_role_party) REFERENCES party (id), 
 	FOREIGN KEY (RoleType) REFERENCES roletype (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE partygroup  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
   	group_party   int(11) NOT NULL,
	name   varchar(75) NOT NULL,
	description   		varchar(255) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
 	FOREIGN KEY (group_party) REFERENCES party (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE person  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
   	person_party   int(11) NOT NULL,
	name   varchar(75) NOT NULL,
	first_name   varchar(75) NOT NULL,
	last_name   varchar(75) NOT NULL,
	gender   		varchar(35) NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
 	FOREIGN KEY (person_party) REFERENCES party (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE billingaccount  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
   	b_account_party   int(11) NOT NULL,
	name   		varchar(75) NOT NULL,
	balance   		decimal(38,2) NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
 	FOREIGN KEY (b_account_party) REFERENCES party (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE accounttransactiontype  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE accounttransactionstatus  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE accounttransaction  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
   	billing_account   int(11) NOT NULL,
   	acct_txn_type   int(11) NOT NULL,
   	transaction_status   int(11) NOT NULL,
	name   varchar(75) NOT NULL,
	amount   		decimal(38,2) NULL,
	db_cr_fg   		varchar(75) NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
 	FOREIGN KEY (billing_account) REFERENCES billingaccount (id), 
 	FOREIGN KEY (acct_txn_type) REFERENCES accounttransactiontype (id), 
 	FOREIGN KEY (transaction_status) REFERENCES accounttransactionstatus (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE filecategory  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE filetype  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
   	file_category   int(11) NOT NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
 	FOREIGN KEY (file_category) REFERENCES filecategory (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE file  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
   	file_type   int(11) NOT NULL,
	name   varchar(75) NOT NULL,
	file_url   		varchar(255) NOT NULL,
	file_size   		varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
 	FOREIGN KEY (file_type) REFERENCES filetype (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE fileclassificationtype  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE fileclassification  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
   	fclass_type   int(11) NOT NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
 	FOREIGN KEY (fclass_type) REFERENCES fileclassificationtype (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE classifiedfile  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
   	class_file   int(11) NOT NULL,
   	file_class   int(11) NOT NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
 	FOREIGN KEY (class_file) REFERENCES file (id), 
 	FOREIGN KEY (file_class) REFERENCES fileclassification (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE partyprofile  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
   	profile_party   int(11) NOT NULL,
   	profile_image   int(11) NULL,
	name   varchar(75) NOT NULL,
	display_name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	profile_status   		varchar(35) NOT NULL,
	description   		varchar(255) NOT NULL,
 	FOREIGN KEY (profile_party) REFERENCES party (id), 
 	FOREIGN KEY (profile_image) REFERENCES file (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE conversationcategory  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE conversationtype  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
   	conv_category   int(11) NOT NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
 	FOREIGN KEY (conv_category) REFERENCES conversationcategory (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE conversation  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
   	conv_type   int(11) NOT NULL,
	name   varchar(75) NOT NULL,
	artifact_code   		varchar(35) NULL,
	artifact_name   varchar(75) NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
 	FOREIGN KEY (conv_type) REFERENCES conversationtype (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE conversationparty  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
   	party_conv   int(11) NOT NULL,
   	conv_party   int(11) NOT NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
 	FOREIGN KEY (party_conv) REFERENCES conversation (id), 
 	FOREIGN KEY (conv_party) REFERENCES party (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE conversationmessage  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
   	msg_conv   int(11) NOT NULL,
   	to_party   int(11) NOT NULL,
   	from_party   int(11) NOT NULL,
	name   varchar(75) NOT NULL,
	artifact_code   		varchar(35) NULL,
	artifact_name   varchar(75) NULL,
	status_code   		varchar(35) NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		LONGTEXT NOT NULL,
 	FOREIGN KEY (msg_conv) REFERENCES conversation (id), 
 	FOREIGN KEY (to_party) REFERENCES party (id), 
 	FOREIGN KEY (from_party) REFERENCES party (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE conversationmessagefile  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
   	conv_msg   int(11) NOT NULL,
   	msg_file   int(11) NOT NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
 	FOREIGN KEY (conv_msg) REFERENCES conversationmessage (id), 
 	FOREIGN KEY (msg_file) REFERENCES file (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE login  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
	name   varchar(75) NOT NULL,
	userName   varchar(75) NOT NULL,
	password   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE signup  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
	name   varchar(75) NOT NULL,
	userName   varchar(75) NOT NULL,
	password   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE password  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
	name   varchar(75) NOT NULL,
	userName   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE academiclevel  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
	name   varchar(75) NOT NULL,
	price_factor   		decimal(38,2) NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE documenttype  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE subjectcategory  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE subjecttype  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
   	subject_category   int(11) NOT NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
 	FOREIGN KEY (subject_category) REFERENCES subjectcategory (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE subject  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
   	subject_type   int(11) NOT NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
 	FOREIGN KEY (subject_type) REFERENCES subjecttype (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE urgency  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
	name   varchar(75) NOT NULL,
	price_factor   		decimal(38,2) NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE writingstyle  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
	name   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE assignment  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
	name   varchar(75) NOT NULL,
   	doc_type   int(11) NOT NULL,
   	subject   int(11) NOT NULL,
   	alevel   int(11) NOT NULL,
   	style   int(11) NOT NULL,
   	urgency   int(11) NOT NULL,
	page_count   		INT(6) NOT NULL,
	sources_count   		INT(6) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	due_date   		timestamp NOT NULL default now(),
	description   		LONGTEXT NOT NULL,
 	FOREIGN KEY (doc_type) REFERENCES classification (id), 
 	FOREIGN KEY (subject) REFERENCES subject (id), 
 	FOREIGN KEY (alevel) REFERENCES academiclevel (id), 
 	FOREIGN KEY (style) REFERENCES writingstyle (id), 
 	FOREIGN KEY (urgency) REFERENCES urgency (id), 
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE account  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
	name   varchar(75) NOT NULL,
	userName   varchar(75) NOT NULL,
	password   varchar(75) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	description   		varchar(255) NOT NULL,
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE message  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
	name   varchar(75) NOT NULL,
	description   		varchar(255) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	PRIMARY KEY( id )
)ENGINE=INNODB;

CREATE TABLE pricingoptions  ( 
	id   int(11) AUTO_INCREMENT NOT NULL,
	entity_code   		varchar(35) NOT NULL,
	name   varchar(75) NOT NULL,
	price_factor   		decimal(38,2) NULL,
	description   		varchar(255) NOT NULL,
	date_created   		timestamp NOT NULL default now(),
	PRIMARY KEY( id )
)ENGINE=INNODB;
