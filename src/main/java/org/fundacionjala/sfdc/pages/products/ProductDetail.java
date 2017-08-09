package org.fundacionjala.sfdc.pages.products;

import org.fundacionjala.sfdc.CommonActions;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.fundacionjala.sfdc.pages.base.HomeBase;

/**
 * Created by abelb on 8/9/2017.
 */
public class ProductDetail extends DetailBase {

  /**
   * {@inheritDoc}
   */
  @Override
  public FormBase clickEditButton() {
    CommonActions.clickElement(editButton);
    return new ProductForm();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public HomeBase deleteItem() {
    clickDeleteButton();
    clickConfirmDeleteButton();
    return new ProductHome();
  }
}
