# ivos-mail

**Cofiguration**

Add the dependency to our pom

``` xml

	<properties>

	...

		<!-- ivos mail version -->
		<ivos-mail.version>1.0.0</ivos-mail.version>

	</properties>

	<dependencies>

		<!-- ivos mail dependency -->
		<dependency>
			<groupId>com.ivoslabs.mail</groupId>
			<artifactId>ivos-mail</artifactId>
			<version>${ivos-mail.version}</version>
		</dependency>

		...

	<dependencies>


```



    - Requerided properties

``` properties

######################
# Mail Configuration #
######################
#
# flag that indicates whether is active the mail component
spring.mail.active=false
# the mail server host, typically an SMTP host
spring.mail.host=smtp.gmail.com
# the mail server port
spring.mail.port=465
# the username for the account at the mail host
spring.mail.username=mailing@ivoslabs.com
# the password for the account at the mail host
spring.mail.password=
# enables the use of the STARTTLS
spring.mail.properties.mail.smtp.starttls.enable=false
# use SSL to connect
spring.mail.properties.mail.smtp.ssl_enable=true
# debug mode
spring.mail.properties.mail.debug=true
#
# the sender of this message
spring.mail.from=Name<no-reply@ivoslabs.com>
# addresses to which replies should be directed
spring.mail.reply=no-reply@ivoslabs.com
#
#################
# Mailing lists #
#################
#
spring.mailing.lists.admin=admin01@ivoslabs.com,admin02@ivoslabs.com,admin03@ivoslabs.com
spring.mailing.lists.support=support01@ivoslabs.com,support02@ivoslabs.com,support03@ivoslabs.com
spring.mailing.lists.other_dist_list=other01@ivoslabs.com,other02@ivoslabs.com,other03@ivoslabs.com


```