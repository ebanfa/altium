/* Location Type */
INSERT INTO locationtype (id, entity_code, name, description, date_created) VALUES (1, 'REGION', 'Region', 'Region', '2000-01-01');
INSERT INTO locationtype (id, entity_code, name, description, date_created) VALUES (2, 'COUNTRY', 'Country', 'Country', '2000-01-01');
INSERT INTO locationtype (id, entity_code, name, description, date_created) VALUES (3, 'STATE', 'State', 'State', '2000-01-01');
INSERT INTO locationtype (id, entity_code, name, description, date_created) VALUES (4, 'PROVINCE', 'Province', 'Province', '2000-01-01');
INSERT INTO locationtype (id, entity_code, name, description, date_created) VALUES (5, 'ADMINISTRATIVE_REGION', 'Administrative Region', 'Administrative Region', '2000-01-01');
INSERT INTO locationtype (id, entity_code, name, description, date_created) VALUES (6, 'COUNTY', 'County', 'County', '2000-01-01');
INSERT INTO locationtype (id, entity_code, name, description, date_created) VALUES (7, 'CITY', 'City', 'City', '2000-01-01');

/* Location */
INSERT INTO location (id, location_type, entity_code, name, description, date_created) VALUES (1, 1, 'AFRICA', 'Africa', 'Africa', '2000-01-01');
INSERT INTO location (id, location_type, entity_code, name, description, date_created) VALUES (2, 1, 'ASIA_PACIFIC', 'Asia-Pacific', 'Asia-Pacific', '2000-01-01');
INSERT INTO location (id, location_type, entity_code, name, description, date_created) VALUES (3, 1, 'EUROPE', 'Europe', 'Europe', '2000-01-01');
INSERT INTO location (id, location_type, entity_code, name, description, date_created) VALUES (4, 1, 'MIDDLE EAST', 'Middle East', 'Middle East', '2000-01-01');
INSERT INTO location (id, location_type, entity_code, name, description, date_created) VALUES (5, 1, 'LATIN AMERICA', 'Latin America', 'Latin America', '2000-01-01');
INSERT INTO location (id, location_type, entity_code, name, description, date_created) VALUES (6, 1, 'NORTH_AMERICA', 'North America', 'North America', '2000-01-01');

/* Countries */
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (7, 2, 3, 'Albania', 'Albania', 'Albania', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (8, 2, 3, 'Andorra', 'Andorra', 'Andorra', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (9, 2, 3, 'Armenia', 'Armenia', 'Armenia', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (10, 2, 3, 'Austria', 'Austria', 'Austria', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (11, 2, 3, 'Azerbaijan', 'Azerbaijan', 'Azerbaijan', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (12, 2, 3, 'Belarus', 'Belarus', 'Belarus', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (13, 2, 3, 'Belgium', 'Belgium', 'Belgium', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (14, 2, 3, 'Bosnia and Herzegovina', 'Bosnia and Herzegovina', 'Bosnia and Herzegovina', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (15, 2, 3, 'Bulgaria', 'Bulgaria', 'Bulgaria', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (16, 2, 3, 'Croatia', 'Croatia', 'Croatia', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (17, 2, 3, 'Cyprus', 'Cyprus', 'Cyprus', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (18, 2, 3, 'Czech Republic', 'Czech Republic', 'Czech Republic', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (19, 2, 3, 'Denmark', 'Denmark', 'Denmark', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (20, 2, 3, 'Estonia', 'Estonia', 'Estonia', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (21, 2, 3, 'Finland', 'Finland', 'Finland', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (22, 2, 3, 'France', 'France', 'France', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (23, 2, 3, 'Georgia', 'Georgia', 'Georgia', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (24, 2, 3, 'Germany', 'Germany', 'Germany', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (25, 2, 3, 'Greece', 'Greece', 'Greece', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (26, 2, 3, 'Hungary', 'Hungary', 'Hungary', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (27, 2, 3, 'Iceland', 'Iceland', 'Iceland', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (28, 2, 3, 'Ireland', 'Ireland', 'Ireland', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (29, 2, 3, 'Italy', 'Italy', 'Italy', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (30, 2, 3, 'Kazakhstan', 'Kazakhstan', 'Kazakhstan', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (31, 2, 3, 'Kosovo', 'Kosovo', 'Kosovo', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (32, 2, 3, 'Latvia', 'Latvia', 'Latvia', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (33, 2, 3, 'Liechtenstein', 'Liechtenstein', 'Liechtenstein', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (34, 2, 3, 'Lithuania', 'Lithuania', 'Lithuania', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (35, 2, 3, 'Luxembourg', 'Luxembourg', 'Luxembourg', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (36, 2, 3, 'Macedonia ', 'Macedonia', 'Macedonia', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (38, 2, 3, 'Malta', 'Malta', 'Malta', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (39, 2, 3, 'Moldova', 'Moldova', 'Moldova', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (40, 2, 3, 'Monaco', 'Monaco', 'Monaco', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (41, 2, 3, 'Montenegro', 'Montenegro', 'Montenegro', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (42, 2, 3, 'Netherlands', 'Netherlands', 'Netherlands', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (43, 2, 3, 'Norway', 'Norway', 'Norway', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (44, 2, 3, 'Poland', 'Poland', 'Poland', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (45, 2, 3, 'Portugal', 'Portugal', 'Portugal', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (46, 2, 3, 'Romania', 'Romania', 'Romania', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (47, 2, 3, 'Russia', 'Russia', 'Russia', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (48, 2, 3, 'San Marino', 'San Marino', 'San Marino', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (49, 2, 3, 'Serbia', 'Serbia', 'Serbia', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (50, 2, 3, 'Slovakia', 'Slovakia', 'Slovakia', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (51, 2, 3, 'Slovenia', 'Slovenia', 'Slovenia', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (52, 2, 3, 'Spain', 'Spain', 'Spain', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (53, 2, 3, 'Sweden', 'Sweden', 'Sweden', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (54, 2, 3, 'Switzerland', 'Switzerland', 'Switzerland', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (55, 2, 3, 'Turkey', 'Turkey', 'Turkey', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (56, 2, 3, 'Ukraine', 'Ukraine', 'Ukraine', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (57, 2, 3, 'United Kingdom', 'United Kingdom', 'United Kingdom', '2000-01-01');

/* Locations in the United Kingdom */
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (58, 5, 57, 'ENGLAND', 'England', 'England', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (59, 5, 57, 'SCOTLAND', 'Scotland', 'Scotland', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (60, 5, 57, 'WALES', 'Wales', 'Wales', '2000-01-01');

/* Locations in England */
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (61, 7, 58, 'London', 'London', 'London', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (62, 7, 58, 'Bournemouth', 'Bournemouth', 'Bournemouth', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (63, 7, 58, 'Burnley', 'Burnley', 'Burnley', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (64, 7, 58, 'Liverpool', 'Liverpool', 'Liverpool', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (65, 7, 58, 'Hull', 'Hull', 'Hull', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (66, 7, 58, 'Leicester', 'Leicester', 'Leicester', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (67, 7, 58, 'Liverpool', 'Liverpool', 'Liverpool', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (68, 7, 58, 'Manchester', 'Manchester', 'Manchester', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (69, 7, 58, 'Middlesbrough', 'Middlesbrough', 'Middlesbrough', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (70, 7, 58, 'Southampton', 'Southampton', 'Southampton', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (71, 7, 58, 'Stoke-on-Trent', 'Stoke-on-Trent', 'Stoke-on-Trent', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (72, 7, 58, 'Sunderland', 'Stoke-on-Trent', 'Stoke-on-Trent', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (73, 7, 58, 'Swansea', 'Swansea', 'Swansea', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (74, 7, 58, 'Watford', 'Watford', 'Watford', '2000-01-01');
INSERT INTO location (id, location_type, parent_location, entity_code, name, description, date_created) VALUES (75, 7, 58, 'West Bromwich', 'West Bromwich', 'West Bromwich', '2000-01-01');

/* Teams in England */
INSERT INTO team (id, team_location, entity_code, name, description, date_created) VALUES (1, 62, 'AFC Bournemouth', 'AFC Bournemouth', 'AFC Bournemouth', '2000-01-01');
INSERT INTO team (id, team_location, entity_code, name, description, date_created) VALUES (2, 61, 'Arsenal', 'Arsenal', 'Arsenal', '2000-01-01');
INSERT INTO team (id, team_location, entity_code, name, description, date_created) VALUES (3, 63, 'Burnley', 'Burnley', 'Burnley', '2000-01-01');
INSERT INTO team (id, team_location, entity_code, name, description, date_created) VALUES (4, 61, 'Chelsea', 'Chelsea', 'Chelsea', '2000-01-01');
INSERT INTO team (id, team_location, entity_code, name, description, date_created) VALUES (5, 61, 'Crystal Palace', 'Crystal Palace', 'Crystal Palace', '2000-01-01');
INSERT INTO team (id, team_location, entity_code, name, description, date_created) VALUES (6, 64, 'Everton', 'Everton', 'Everton', '2000-01-01');
INSERT INTO team (id, team_location, entity_code, name, description, date_created) VALUES (7, 65, 'Hull City', 'Hull City', 'Hull City', '2000-01-01');
INSERT INTO team (id, team_location, entity_code, name, description, date_created) VALUES (8, 66, 'Leicester City', 'Leicester City', 'Leicester City', '2000-01-01');
INSERT INTO team (id, team_location, entity_code, name, description, date_created) VALUES (9, 64, 'Liverpool', 'Liverpool', 'Liverpool', '2000-01-01');
INSERT INTO team (id, team_location, entity_code, name, description, date_created) VALUES (10, 68, 'Manchester City', 'Manchester City', 'Manchester City', '2000-01-01');
INSERT INTO team (id, team_location, entity_code, name, description, date_created) VALUES (11, 68, 'Manchester United', 'Manchester United', 'Manchester United', '2000-01-01');
INSERT INTO team (id, team_location, entity_code, name, description, date_created) VALUES (12, 69, 'Middlesbrough', 'Middlesbrough', 'Middlesbrough', '2000-01-01');
INSERT INTO team (id, team_location, entity_code, name, description, date_created) VALUES (13, 70, 'Southampton', 'Southampton', 'Southampton', '2000-01-01');
INSERT INTO team (id, team_location, entity_code, name, description, date_created) VALUES (14, 71, 'Stoke City', 'Stoke City', 'Stoke City', '2000-01-01');
INSERT INTO team (id, team_location, entity_code, name, description, date_created) VALUES (15, 72, 'Sunderland', 'Sunderland', 'Sunderland', '2000-01-01');
INSERT INTO team (id, team_location, entity_code, name, description, date_created) VALUES (16, 73, 'Swansea City', 'Swansea City', 'Swansea City', '2000-01-01');
INSERT INTO team (id, team_location, entity_code, name, description, date_created) VALUES (17, 61, 'Tottenham Hotspur', 'Tottenham Hotspur', 'Tottenham Hotspur', '2000-01-01');
INSERT INTO team (id, team_location, entity_code, name, description, date_created) VALUES (18, 74, 'Watford', 'Watford', 'Watford', '2000-01-01');
INSERT INTO team (id, team_location, entity_code, name, description, date_created) VALUES (19, 75, 'West Bromwich Albion', 'West Bromwich Albion', 'West Bromwich Albion', '2000-01-01');
INSERT INTO team (id, team_location, entity_code, name, description, date_created) VALUES (20, 61, 'West Ham United', 'West Ham United', 'West Ham United', '2000-01-01');
