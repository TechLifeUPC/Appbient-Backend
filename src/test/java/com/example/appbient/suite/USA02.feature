Feature: Búsqueda de ONG’s

  Scenario Outline: El voluntario ingresa al formulario de búsqueda.
  Given el voluntario ha accedido a su cuenta
  When encuentre el apartado de búsquedas
  Then visualizará un formulario en donde podrá seleccionar entre buscar proyectos o buscar ONG.
    Examples:


  Scenario Outline: El voluntario obtiene resultados de búsqueda de ONG’s.
  Given el voluntario ha seleccionado búsqueda de ONG’s
  When rellene el formulario de búsqueda
  And de click al botón buscar
  Then se enlistarán los resultados conseguidos
    Examples:
      | OngId | Name     | Descripcion            | Local                           |
      | 1     | "Rotary" | "Rotary International" | "av.costa sol 123, Lima, Peru"  |
      | 2     | "Red"    | "Red de Apoyo"         | "av.luna llena 232, Lima, Peru" |

  Scenario Outline: El voluntario no obtiene resultados de ONG’s.
  Given el voluntario ha seleccionado búsqueda de ONG’s
  When rellene el formulario de búsqueda
  And de click al botón buscar
  Then se mostrará el <mensaje> “No se obtuvieron resultados de su busqueda”
    Examples:
      | mensaje                                      |
      | "No se obtuvieron resultados de su busqueda" |
      |                                              |