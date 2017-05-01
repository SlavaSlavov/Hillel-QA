<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <parameter name="selenium.host" value="localhost" />
    <parameter name="selenium.port" value="3737" />
    <parameter name="selenium.browser" value="*firefox" />
    <parameter name="selenium.url" value="http://demo.opensourcecms.com/wordpress/" />





    <include name="launchSite" />
    <include name="openAdminPage" />
    <include name="loginAsAdmin" />
    <include name="navigateNewPost" />
    <include name="writeBlogPost" />
    <include name="publishBlogPost" />
    <include name="verifyBlogPost" />
</xsl:stylesheet>