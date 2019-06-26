package by.butramyou.todolist.domain;

import javax.persistence.*;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String textTask;
    private LocalDateTime problemStatementDate;
    private Date deadline;
    private LocalDateTime implementationDate;
    private boolean completeness;
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User authorTask;

    public Task() {
    }


    public Task(String textTask, Date deadline, User user) throws ParseException {
        this.authorTask = user;
        this.textTask = textTask;
        this.problemStatementDate = LocalDateTime.now();
        this.deadline = deadline;
        this.tag = "New";

    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAuthorName() {
        return authorTask != null ? authorTask.getUsername() : "<none>";
    }

    public User getAuthorTask() {
        return authorTask;
    }

    public void setAuthorTask(User authorTask) {
        this.authorTask = authorTask;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextTask() {
        return textTask;
    }

    public void setTextTask(String textTask) {
        this.textTask = textTask;
    }

    public LocalDateTime getProblemStatementDate() {
        return problemStatementDate;
    }

    public void setProblemStatementDate(LocalDateTime problemStatementDate) {
        this.problemStatementDate = problemStatementDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public LocalDateTime getImplementationDate() {
        return implementationDate;
    }

    public void setImplementationDate(LocalDateTime implementationDate) {
        this.implementationDate = implementationDate;
    }

    public boolean isCompleteness() {
        return completeness;
    }

    public void setCompleteness(boolean completeness) {
        this.completeness = completeness;
    }
}
