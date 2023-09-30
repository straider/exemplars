CREATE
TABLE   exemplars.vehicles (
            id          INT4                NOT NULL    DEFAULT nextval( 'vehicles_seq' :: REGCLASS ),
            make        VARCHAR( 255 )      NULL,
            model       VARCHAR( 255 )      NULL,
            "year"      BYTEA               NULL,
            fuel        VARCHAR( 255 )      NULL,
            price       NUMERIC( 38, 2 )    NULL,
            acquired_on DATE                NULL,
            sold_on     DATE                NULL,
            CONSTRAINT  vehicles_key        PRIMARY KEY ( id )
);
