package com.accolite.msproject;

import com.accolite.msproject.model.Grad;
import com.accolite.msproject.model.Institute;
import com.accolite.msproject.model.Location;
import com.accolite.msproject.model.Skill;

import java.util.HashSet;
import java.util.Set;

public class EntityData {

    public static String[] getSkillsData(){
        String [] skillArray=new String[]{"Java","Angular","Android","Spring","Other"};
        return skillArray;
    }
    public static String[] getLocData(){
        String [] locArray=new String[]{"Mumbai","Delhi","Bangalore","Chennai","Other"};

        return locArray;
    }
    public static String[] getInstrData(){
        String [] instrArray=new String[]{"DJ","KJ","MJ","LJ","Other"};
        return instrArray;
    }
    public static Grad getGrad(){
        int i=1;
        Grad grad = new Grad();
        grad.setLoc(new Location(i+1, getLocData()[i]));
        grad.setInstitute(new Institute(i+1, getInstrData()[i]));
        grad.setJoin_loc(new Location(i+1, getLocData()[i]));
        grad.setContact("9082177574");
        grad.setDescription("desc.....");
        grad.setFeedback("feed...");
        grad.setName("Grad" + i+1);
        grad.setEmail("grad" + i+1 + "@gmail.com");
        grad.setTen_join_date("2021-03-11");
        Set<Skill> skillSet = new HashSet<>();
        skillSet.add(new Skill(i+1, getSkillsData()[i]));
        skillSet.add(new Skill(i+1+ 1, getSkillsData()[i+1]));
        grad.setSkills(skillSet);
        return grad;
    }



}
