package pages;

public class GooglePage extends BasePage {
    // private String searchButton = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]";
    private String searchButton = "//input[@value='Buscar con Google']";
    //private String searchTextField = "//input[@title='Buscar']";
    private String searchTextField = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea";
    private String firstResult = "//h3[contains(text(),'Descargar Java para Windows')]";
    private String pageTitle = driver.getTitle();
  
    public GooglePage() {
      super(driver);
    }
  
    public void navigateToGoogle() {
      //* navigateTo es un método estatico de la BasePage
      navigateTo("https://www.google.com");
    }
  
    //* Método para realizar click en el boton de google
    public void clickGoogleSearch() {
      clickElement(searchButton);
    }
  
    //* Método para escribir en el input de google
    public void enterSearchCriteria(String criteria) {
      write(searchTextField, criteria);
    }
  
    //* A CONTINUACION LO QUE CORRESPONDE A LAS VALIDACIONES */
    public String firstResult() {
      return textFromElement(firstResult);
    }

    public String pageTitleResult() {
      return textFromElement(pageTitle);
    }  
  }