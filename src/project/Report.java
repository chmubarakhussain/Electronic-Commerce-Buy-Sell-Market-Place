/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Bhai Aziz
 */
public class Report {
    int    id;
    int    ad_id;
    String    report_type;
    String description;
    static int id_count=0;
    
    
    public Report( int ad_id, String report_type, String description) {
        this.id = id_count++;
        this.ad_id = ad_id;
        this.report_type = report_type;
        this.description = description;
    }

    public Report() {
    }
}
