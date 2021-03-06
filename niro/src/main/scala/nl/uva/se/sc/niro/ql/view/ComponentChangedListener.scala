package nl.uva.se.sc.niro.ql.view

import nl.uva.se.sc.niro.ql.view.component.Component

/**
  * Classes that implement the @{@link ComponentChangedListener} trait are responsible for responding to a changed
  * value of a component.
  */
trait ComponentChangedListener {

  /**
    * Update the model based to a component value.
    *
    * @param component the component which value has changed.
    */
  def componentChanged(component: Component[_]): Unit
}
