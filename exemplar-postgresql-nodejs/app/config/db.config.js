const SEQUELIZE_HOSTNAME = process.env.SEQUELIZE_HOSTNAME || 'localhost';
const SEQUELIZE_DATABASE = process.env.SEQUELIZE_DATABASE || 'mydb';
const SEQUELIZE_USERNAME = process.env.SEQUELIZE_USERNAME || 'admin';
const SEQUELIZE_PASSWORD = process.env.SEQUELIZE_PASSWORD;
module.exports = {
    HOST    : SEQUELIZE_HOSTNAME,
    DB      : SEQUELIZE_DATABASE,
    USERNAME: SEQUELIZE_USERNAME,
    PASSWORD: SEQUELIZE_PASSWORD,
    dialect : 'postgres',
    pool: {
        max: 5,
        min: 0,
        acquire: 30000,
        idle: 10000
    }
};