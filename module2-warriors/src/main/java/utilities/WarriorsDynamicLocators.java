package utilities;

public class WarriorsDynamicLocators {

    public static final String RADIOBTN_PRODUCT = "//span[text()='%s']/parent::a";
    public static final String BTN_SUBMENU = "//a[@role='button' and text()='%s']";
    public static final String BTN_THREEDOTS_SUBMENU = "//a[@title='%s']";
    public static final String TEXT_PAGE_TITLE = "//h3[text()='%s']";
    public static final String BTN_ARTICLE_RESULTS = "//a[contains(@href,'%s') and contains(@data-testid,'article-link')]";
    public static final String TEXT_ARTICLE_RESULTS_GE = "//a[contains(@href,'%s') and contains(@data-testid,'article-link')]/following-sibling::div//time/span[number(translate(text(), 'd,', '')) >='%s']";
}
