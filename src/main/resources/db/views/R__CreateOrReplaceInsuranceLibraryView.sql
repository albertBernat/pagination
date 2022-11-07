-- insurance_id, start_date, end_date, car_model, car_make, owner_name, owner_last_name
CREATE OR REPLACE VIEW INSURANCE_LIBRARY_PAGE_VIEW AS
SELECT i.id         AS INSURANCE_ID,
       i.start_date as START_DATE,
       i.end_date   AS END_DATE,
       c.model      AS CAR_MODEL,
       m.name       AS CAR_MAKE,
       o.firstname  AS OWNER_NAME,
       o.lastname   AS OWNER_LAST_NAME
FROM insurance AS i
         LEFT JOIN car c on i.car_id = c.id
         Left Join make m on m.id = c.make_id
         left join owner o on o.id = c.owner_id;