INSERT INTO public."attributes" ("name",value) VALUES
	 ('Height','Tall'),
	 ('Height','Short');

INSERT INTO public.employees (car,date_of_birth,"name",x_coordinate,y_coordinate) VALUES
	 (true,'1982-07-08 00:00:00','Nikos','40.641414','22.939843'),
	 (true,'1977-07-07 01:00:00','Maria','40.640494','22.947325'),
	 (false,'1987-07-10 00:00:00','Giannis','40.636659','22.949878'),
	 (true,'1987-07-02 00:00:00','Katerina','40.631920','22.952002');

	 
INSERT INTO public.employees_attributes (user_id,attribute_id) VALUES
	 (15,26),
	 (16,26),
	 (17,26),
	 (18,26);
