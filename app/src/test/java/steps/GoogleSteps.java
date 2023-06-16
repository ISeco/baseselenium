package steps;

import static org.junit.Assert.assertSame;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.GooglePage;

public class GoogleSteps {
    
    GooglePage google = new GooglePage();

    @Given("^que estoy en la página de búsqueda de Google$")
    public void navigateToGoogle() {
      google.navigateToGoogle();
    }
  
    @When("^introduzco un criterio de búsqueda$")
    public void enterSearchCriteria() {
      google.enterSearchCriteria("Java");
    }
  
    @And("^haga click en el botón de búsqueda$")
    public void clickSearchButton() {
      google.clickGoogleSearch();
    }
  
    @Then("^los resultados coinciden con los criterios$")
    public void validateResults() {
      //* De esta forma estamos creando un test desde Steps definitions */
      Assert.assertEquals("Descargar Java para Windows", google.firstResult());
      Assert.assertEquals("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea", google.inputResult());
      Assert.assertEquals("//input[@value='Buscar con Google']", google.buttonResult());
      // assertSame("Descargar Java para Windows", google.firstResult());
    }
}
