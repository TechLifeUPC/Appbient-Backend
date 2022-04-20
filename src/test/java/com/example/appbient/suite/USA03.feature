Feature: Búsqueda en el foro

  Scenario Outline: El voluntario ingresa al foro.
  Given el voluntario ha accedido a su cuenta,
  When de click al botón de Foro
  Then ingresara al foro de la aplicacion
    Examples:
      | ForoId | Name           | Description          | Topic       | Date       |
      | 1      | "Hello World!" | "Foro de bienvenida" | "Ambiental" | 21/03/2022 |

  Scenario Outline: El obtiene resultados de búsqueda en el foro
  Given el voluntario ha accedido al foro
  When escriba una palabra clave o tema especifico
  And de click al botón buscar
  Then se realizará la búsqueda solicitada mostrando resultados
    Examples:
      | ForoId | Name           | Description          | Topic       | Date       |
      | 1      | "Hello World!" | "Foro de bienvenida" | "Ambiental" | 21/03/2022 |

  Scenario Outline: El voluntario no obtiene resultados de búsqueda en el foro.
  Given el voluntario ha accedido al foro
  When escriba una palabra clave o tema específico en el buscador
  And de click al botón buscar
  Then se mostrará el <mensaje> “No se obtuvieron resultados de búsqueda”
    Examples:
      | mensaje                                   |
      | "No se obtuvieron resultados de búsqueda"|