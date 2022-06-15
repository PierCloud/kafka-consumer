package kp.com.example.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Topic")
@Table(
        name = "topic",
        uniqueConstraints = {
                @UniqueConstraint(name = "topic_id_unique", columnNames = "id")
        }
)
public class Topic {

    @Id
    @SequenceGenerator(
            name = "topic_sequence",
            sequenceName = "topic_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "topic_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "topic_name",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String topicName;

    @Column(
            name = "message",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String message;

    public Topic(String firstName,
                 String lastName) {
        this.topicName = firstName;
        this.message = lastName;

    }

    public Topic() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "topic{" +
                "id=" + id +
                ", topicName='" + topicName + '\'' +
                ", message='" + message + '\''+
                '}';
    }
}