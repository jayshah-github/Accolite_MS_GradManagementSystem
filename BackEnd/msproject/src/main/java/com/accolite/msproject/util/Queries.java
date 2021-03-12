package com.accolite.msproject.util;

public  class Queries {

    //jpa queries
    public static final String SKILL_LABEL="select s.name from Skill s";
    public static final String LOC_LABEL="select l.name from Location l";
    public static final String INSTI_LABEL="select i.name from Institute i";
    public static final String YEAR_LABEL="select year(ten_join_date) as year from Grad group by year";
    //pie chart queries
    public static final String SKILL_PIE_DATA="select (count(*)*100/(Select Count(*) From grad_skills)) from grad_skills group by skills_id";
    public static final String INSTI_PIE_DATA="select (count(*)*100/(Select Count(*) From grad)) from grad group by institute_id";
    public static final String LOC_PIE_DATA="select (count(*)*100/(Select Count(*) From grad)) from grad group by join_loc_id";
    public static final String YEAR_PIE_DATA="select (count(id)*100/(Select Count(*) From grad)) from grad group by (select year(ten_join_date) as year)";
    //bar chart queries
    public static final String SKILL_BAR_DATA="select count(*) from grad_skills group by skills_id";
    public static final String INSTI_BAR_DATA="select count(*) from Grad group by institute_id";
    public static final String LOC_BAR_DATA="select count(*) from grad group by join_loc_id";
    public static final String YEAR_BAR_DATA="select count(*) from Grad  group by (select year(ten_join_date) as year)";
    //Labels
    public static final String SKILL_L="skill";
    public static final String INSTI_L="institute";
    public static final String YEAR_L="join year";
    public static final String GRAD_L="Graduates";
}

