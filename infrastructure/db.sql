CREATE ROLE "order_users" SUPERUSER;
CREATE ROLE "order_admins" SUPERUSER;
CREATE ROLE "order-systemtest" SUPERUSER;

GRANT ALL PRIVILEGES ON DATABASE "postgres-order" TO "order_users";