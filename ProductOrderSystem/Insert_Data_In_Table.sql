INSERT INTO `user` VALUES (1,'Aditi','Bisht','Bisht@gmail.com'),(2,'Tina','Rawat','rawat@gmail.com'),(3,'Shubham','Kukreti','kukreti@gmail.com');

INSERT INTO `address` VALUES (1,'Uttrakhand','Office','It Park','Dehradun',45,2),(2,'Uttrakhand','Home','It Park','Dehradun',112,2),(3,'Uttrakhand','Home','It Park','Dehradun',112,3);

INSERT INTO `order_details` VALUES (1,'2022-06-09 00:00:00.000000','1st Order',1001,_binary '','2022-06-07 00:00:00.000000',1),(2,NULL,'Kitchen Items',1002,_binary '\0','2022-06-24 00:00:00.000000',1),(3,'2022-04-01 00:00:00.000000','books Order',1003,_binary '','2022-03-25 00:00:00.000000',3),(4,NULL,'Phone',1004,_binary '\0','2022-03-01 00:00:00.000000',2),(5,'2022-05-25 00:00:00.000000','All Items',1005,_binary '','2022-03-02 00:00:00.000000',1);

INSERT INTO `order_product` VALUES (1,1),(1,3),(2,1),(2,3),(3,1),(3,3),(3,2),(4,1),(5,1),(5,3);