package org.inmeta.tasksystem.application.dto;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 15.04.13
 * Time: 15:54
 * To change this template use File | Settings | File Templates.
 */
public class CustomerDto extends AbstractResponse {
    private String realFistName = "";
    private String realLastName = "";
    private String street = "";
    private String zipCode = "";
    private String area = "";


    public String getRealFistName() {
        return realFistName;
    }

    public void setRealFistName(final String realFistName) {
        this.realFistName = realFistName;
    }

    public String getRealLastName() {
        return realLastName;
    }

    public void setRealLastName(final String realLastName) {
        this.realLastName = realLastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(final String area) {
        this.area = area;
    }
}
