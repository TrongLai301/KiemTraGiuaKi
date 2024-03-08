package com.example.demo2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Bạn cần nhập tên!")
    private String name;
    @Min(value = 0, message = "Bạn cần nhập số tuổi lớn hơn hoặc bằng 0")
    private int age;
    @NotBlank(message = "Bạn cần nhập giới tính!")
    private String gender;

    private Date date;
    @NotBlank(message = "Bạn cần nhập địa chỉ!")
    private String address;
    private String part;
    private String position;
    private Double salary;
    private Date timeStartWork;
    private String status;
    private String insuranceInformation;

    public Employee(Long id, String name, int age, String gender, Date date, String address, String part, String position, Double salary, Date timeStartWork, String status, String insuranceInformation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.date = date;
        this.address = address;
        this.part = part;
        this.position = position;
        this.salary = salary;
        this.timeStartWork = timeStartWork;
        this.status = status;
        this.insuranceInformation = insuranceInformation;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date.toString();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getTimeStartWork() {
        return timeStartWork.toString();
    }

    public void setTimeStartWork(Date timeStartWork) {
        this.timeStartWork = timeStartWork;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInsuranceInformation() {
        return insuranceInformation;
    }

    public void setInsuranceInformation(String insuranceInformation) {
        this.insuranceInformation = insuranceInformation;
    }
}
