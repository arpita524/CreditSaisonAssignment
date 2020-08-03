package com.threesum.assignment.model;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "Threesum")
@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
@SequenceGenerator(
        name = "seqid-gen",
        sequenceName = "Uniqueid",
        initialValue = 1, allocationSize = 1)
public class ThreeSum {
    @Id
    @Column(name = "ID")
    @GeneratedValue()
    private long id;

    @Type(type = "list-array")
    @Column(
            name = "NumbersList",
            columnDefinition = "text[]"
    )
    private List<String> list;

    @Column (name = "Sum")
    private int number;

    public ThreeSum() {
    }

    public ThreeSum(long id, List<String> list, int number, List<String> answer, String errorCode) {
        this.id = id;
        this.list = list;
        this.number = number;
        this.answer = answer;
        this.errorCode = errorCode;
    }

    @Type(type = "list-array")
    @Column(
            name = "Answer",
            columnDefinition = "text[]"
    )
    private List<String> answer;

    @Column(name="error_code")
    private String errorCode;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }
}