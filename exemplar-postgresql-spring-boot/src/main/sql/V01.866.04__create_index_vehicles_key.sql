CREATE
UNIQUE
INDEX   IF NOT EXISTS       vehicles_key
ON      exemplars.vehicles  USING btree ( id )
;
