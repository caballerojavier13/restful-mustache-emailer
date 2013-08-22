restful-mustache-emailer
========================

Example webapp for sending an email via a Spring MVC service using JavaMail with a Mustache.java template.

Using Mustache: https://github.com/spullara/mustache.java

Setup your SMTP details in: com.joejag.restfulmustacheemailer.EmailSender#getProperties()

Not actually restful! But you know what I mean.

To run:
```
mvn package jetty:run
curl http://localhost:9090/restful-mustache-emailer/
```
