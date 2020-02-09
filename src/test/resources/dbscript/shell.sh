#!/bin/bash

winpty docker exec postgresdb bash -c \
	"su postgres && \
	psql -U postgres -d postgres -c \"\
	drop table if exists answer;\
	drop table if exists solution;\
	drop table if exists exercise;\
	drop sequence if exists hibernate_sequence;\
	\
	create table answer (\
		id integer not null,\
        	text varchar(255),\
        	exercise_id integer,\
		primary key (id)\
	);\
	create table exercise (\
		id integer not null,\
		question varchar(255),\
		primary key (id)\
	);\
	create table solution (\
		id integer not null,\
		text varchar(255),\
		exercise_id integer,\
		primary key (id)\
	);\
	alter table answer \
       	add constraint FKawx9our67ld35s1wqgkfficmi \
       	foreign key (exercise_id) \
      	references exercise;\
	alter table solution \
       	add constraint FKna5e82y64wvllwuxqw1dsidye \
       	foreign key (exercise_id) \
       	references exercise;\
	\
	insert into exercise values(1001, '\\int_0^{+\\infty} x^n e^{-x} \\,dx');\
	insert into exercise values(1002, '\\lim_{x \\to +\\infty} \\frac{3x^2 +7x^3}{x^2 +5x^4}');\
	insert into exercise values(1003, '\\int \\sin{x}\\cos{x} \\,dx');\
	insert into exercise values(1004, '\\int x^3 \\,dx');\
	\
	insert into answer values(11001, 'n!', 1001);\
	insert into answer values(11002, '0', 1002);\
	insert into answer values(11003, '\\frac{1}{2}\\sin{x}^2+c', 1003);\
	insert into answer values(11004, '\\frac{1}{4}x^4+c', 1004);\
	\
	insert into solution values(11001, 'trivial', 1001);\
	insert into solution values(11002, 'easy', 1002);\"\
	&&\
	exit"

