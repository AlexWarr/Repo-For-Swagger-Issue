VALUES
('2022-04-28 11:57:22',
'Spring',
'Flowering',
'Rainy');

INSERT INTO `4est`.`plant`
(`Body_Trunk_Stem_Description`,
`Branch_Leaf_Pattern_Description`,
`Flower_Fruit_Description`,
`Plant_Notes`,
`Plant_Species_Plant_Latin_Name`,
`Location_Location_Name`)
VALUES
('Small Tree with dark brown bark, roughly 4in diameter.',
'Long slender barnaches, currently very brittle, no leaves.',
'A few shriveled berries are still attatched to the branches',
'Tree is part of a small stand of trees growing very tightly together.',
'Prunus Virginiana Demissa',
'Mink Creek West Fork Trail');

INSERT INTO `4est`.`plant`
(`Body_Trunk_Stem_Description`,
`Branch_Leaf_Pattern_Description`,
`Flower_Fruit_Description`,
`Plant_Notes`,
`Plant_Species_Plant_Latin_Name`,
`Location_Location_Name`)
VALUES
('Small shrub with light grey bark, less than 0.5 in diameter, grows as tightly packed bush.',
'Long slender branches with large-lobed small green leaves.',
'many small, plump orange colored berries, each with what appears to be a stem protruding from the end of the berry. Small clumps of yellow flowers dot the bush as well.',
'Bush grows on the edge of the trail on an extremely steep slope. The stems range from 4 to 6 feet tall.',
'Ribes Aureum Pursh',
'City Creek Lower Trail');

INSERT INTO `4est`.`plant`
(`Body_Trunk_Stem_Description`,
`Branch_Leaf_Pattern_Description`,
`Flower_Fruit_Description`,
`Plant_Notes`,
`Plant_Species_Plant_Latin_Name`,
`Location_Location_Name`)
VALUES
('large shrub with light grey bark, roughly 2 inches in diameter, grows as tightly packed bush.',
'Long, slender branches with long, spearshaped, jagged leaves.',
'Bush is covered in large umbles of white flowers. the umbles are flat.',
'Bush grows in a clearing roughly 20 feet off of the trail. The stems are nearly 6 feet tall.',
'Sambucus Nigra Cerulea',
'Scout Mountain Overlook Trail');

INSERT INTO `4est`.`location_has_plant_species`
(`Location_Location_Name`,
`Plant_Species_Plant_Latin_Name`)
VALUES
('Mink Creek West Fork Trail',
'Prunus Virginiana Demissa'),
('City Creek Lower Trail',
'Ribes Aureum Pursh'),
('Scout Mountain Overlook Trail',
'Sambucus Nigra Cerulea');
SELECT * FROM 4est.location_has_plant_species;

INSERT INTO `4est`.`entry`
(`Notes`,
`Location_Location_Name`,
`Plant_Plant_ID`,
`Plant_Plant_Species_Plant_Latin_Name`,
`Moment_Date`)
VALUES
('This is the initial Dscovery of the plant',
'Mink Creek West Fork Trail',
3,
'Prunus Virginiana Demissa',
'2023-01-28 01:57:22');

INSERT INTO `4est`.`entry`
(`Notes`,
`Location_Location_Name`,
`Plant_Plant_ID`,
`Plant_Plant_Species_Plant_Latin_Name`,
`Moment_Date`)
VALUES
('This is the initial Dscovery of the plant',
'Scout Mountain Overlook Trail',
5,
'Sambucus Nigra Cerulea',
'2022-07-28 10:57:22');

INSERT INTO `4est`.`entry`
(`Notes`,
`Location_Location_Name`,
`Plant_Plant_ID`,
`Plant_Plant_Species_Plant_Latin_Name`,
`Moment_Date`)
VALUES
('This is the initial Dscovery of the plant',
'City Creek Lower Trail',
4,
'Ribes Aureum Pursh',
'2022-04-28 10:57:22');