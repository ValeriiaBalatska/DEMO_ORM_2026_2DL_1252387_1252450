INSERT INTO CARGROUP (name, num_doors, price_per_day, carclass) VALUES ('Economy', 5, 29.99, 'UTILITY');
INSERT INTO CARGROUP (name, num_doors, price_per_day, carclass) VALUES ('Premium', 4, 89.99, 'LUXURY');
INSERT INTO CARGROUP (name, num_doors, price_per_day, carclass) VALUES ('Van', 5, 59.99, 'COMMERCIAL');
INSERT INTO CAR (license_plate, manufacture_year, acquisition_year, color, engine_displacement, car_group_id) VALUES ('AA-00-BB', 2020, 2021, 'Red', 1200, 1);
INSERT INTO CAR (license_plate, manufacture_year, acquisition_year, color, engine_displacement, car_group_id) VALUES ('CC-11-DD', 2022, 2022, 'Black', 2000, 2);
INSERT INTO CAR (license_plate, manufacture_year, acquisition_year, color, engine_displacement, car_group_id) VALUES ('EE-22-FF', 2019, 2020, 'White', 2500, 3);
INSERT INTO CLIENT (client_type, name, address, phone_number, email, remarks, company_name, tax_id, citizen_id, date_of_birth) VALUES ('CORPORATE', 'John Smith', '123 Business Ave', '912345678', 'john@corp.com', 'VIP client', 'TechCorp Ltd', 'PT123456789', NULL, NULL);
INSERT INTO CLIENT (client_type, name, address, phone_number, email, remarks, company_name, tax_id, citizen_id, date_of_birth) VALUES ('INDIVIDUAL', 'Maria Silva', '456 Main St', '963852741', 'maria@email.com', 'Regular client', NULL, NULL, '12345678', '15-05-1990');