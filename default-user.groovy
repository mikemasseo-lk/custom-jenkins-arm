/*
 * Create an admin user.
 */
import jenkins.model.*
import hudson.security.*

println "--> creating admin user"

def adminUsername = System.getenv("JENKINS_ADMIN_USER")
def adminPassword = System.getenv("JENKINS_ADMIN_PASS")
assert adminPassword != null : "No JENKINS_ADMIN_USER env var provided, but required"
assert adminPassword != null : "JENKINS_ADMIN_PASS env var provided, but required"

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount(adminUsername, adminPassword)
Jenkins.instance.setSecurityRealm(hudsonRealm)
def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
strategy.setAllowAnonymousRead(false)
Jenkins.instance.setAuthorizationStrategy(strategy)

Jenkins.instance.save()
