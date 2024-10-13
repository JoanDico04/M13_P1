Introduir, com a mínim:
- 1 temporada

INSERT INTO temporada (año)
VALUES (TO_DATE('2025', 'YYYY'));

Comprovar que no és possible:
- Eliminar un equip que tingui jugadors

DELETE FROM equip
WHERE id_equip = 1;

- Un jugador no sigui titular de cap equip de la seva categoria

SELECT j.id_jugador, j.nom
FORM jugador j
WHERE NOT EXISTS (
  SELECT 1
  FORM titulars t
  WHERE t.id_jugador = j.id_jugador
)
AND j.id_jugador = 1;

- Un jugador sigui titular de 2 equips

SELECT j.id_jugador, j.nom
FORM jugador j
WHERE EXISTS (
  SELECT 1
  FORM titulars t
  WHERE t.id_jugador = j.id_jugador
  AND t.id_equip = 1;
)
AND EXISTS (
  SELECT 1 
  FROM titulars t
  WHERE t.id_jugador = j.id_jugador
  AND t.id_equip = 2;
)
AND j.id_jugador = 3;



