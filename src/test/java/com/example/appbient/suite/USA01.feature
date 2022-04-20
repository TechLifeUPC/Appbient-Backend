Feature: Búsqueda de proyectos

  Scenario Outline: Como voluntario quiero conocer los proyectos ambientales que se estén llevando a cabo actualmente para conocer más información sobre ellos.

    Given el voluntario ha accedido a su cuenta
    When encuentre el apartado de búsquedas
    Then visualizará un formulario en donde podrá seleccionar entre buscar proyectos o buscar ONG.
    Examples: 


  Scenario Outline : El voluntario obtiene resultados de búsqueda de proyectos.

    Given el voluntario ha seleccionado búsqueda de proyectos
    When rellene el formulario de búsqueda
    And de click al botón buscar
    Then se enlistarán los resultados conseguidos
      Examples:
        | ProyeectoId | OngId | Nombre                 | Descripción             | Fecha      |
        | 1           | 2     | "Replantando la selva" | "Replantaremos arboles" | 22/10/2022 |


  Scenario Outline : El voluntario no obtiene resultados de búsqueda de proyectos.

    Given el voluntario ha seleccionado búsqueda de proyectos
    When rellene el formulario de búsqueda
    And de click al botón buscar
    Then se mostrará el <mensaje> “No se obtuvieron resultados de su búsqueda”
      Examples:
        | mensaje                                      |
        | "No se obtuvieron resultados de su búsqueda" |
