/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malintha_agency.model;

import java.io.Serializable;


/**
 *
 * @author User PC
 */

public class Route implements Serializable{
    
    private int routeid;
    private int routeno;
    private String routename;
    private String extrainfo;

    public Route(int routeno, String routename, String extrainfo) {
        this.routeno = routeno;
        this.routename = routename;
        this.extrainfo = extrainfo;
    }

    public Route(int routeid, int routeno, String routename, String extrainfo) {
        this.routeid = routeid;
        this.routeno = routeno;
        this.routename = routename;
        this.extrainfo = extrainfo;
    }

    public Route() {
    }
  
  
    
    public int getRouteid() {
        return routeid;
    }

    public void setRouteid(int routeid) {
        this.routeid = routeid;
    }

    public int getRouteno() {
        return routeno;
    }

    public void setRouteno(int routeno) {
        this.routeno = routeno;
    }

    public String getRoutename() {
        return routename;
    }

    public void setRoutename(String routename) {
        this.routename = routename;
    }

    public String getExtrainfo() {
        return extrainfo;
    }

    public void setExtrainfo(String extrainfo) {
        this.extrainfo = extrainfo;
    }
       
    
}
