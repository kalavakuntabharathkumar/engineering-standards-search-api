package dev.demo.standards;
import jakarta.persistence.*;
@Entity @Table(name="standards", indexes={@Index(name="idx_standard_title", columnList="title"), @Index(name="idx_standard_code", columnList="code", unique=true)})
public class Standard {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,length=40,unique=true) private String code;
 @Column(nullable=false,length=200) private String title;
 @Column(nullable=false,columnDefinition="text") private String body;
 @Column(nullable=false) private String version;
 protected Standard() {}
 public Standard(String code,String title,String body,String version){this.code=code;this.title=title;this.body=body;this.version=version;}
 public Long getId(){return id;} public String getCode(){return code;} public String getTitle(){return title;} public String getBody(){return body;} public String getVersion(){return version;}
 public void setCode(String v){code=v;} public void setTitle(String v){title=v;} public void setBody(String v){body=v;} public void setVersion(String v){version=v;}
}
