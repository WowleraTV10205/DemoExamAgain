CREATE TABLE IF NOT EXISTS `Manufacturer` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) CHARACTER SET 'utf8mb4' NOT NULL,
  `StartDate` DATE NULL,
  PRIMARY KEY (`ID`));

REATE TABLE IF NOT EXISTS `Product` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(100) CHARACTER SET 'utf8mb4' NOT NULL,
  `Cost` DECIMAL(19,4) NOT NULL,
  `Description` LONGTEXT CHARACTER SET 'utf8mb4' NULL,
  `MainImagePath` VARCHAR(1000) CHARACTER SET 'utf8mb4' NULL,
  `IsActive` TINYINT(1) NOT NULL,
  `ManufacturerID` INT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_Product_Manufacturer`
    FOREIGN KEY (`ManufacturerID`)
    REFERENCES `Manufacturer` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS tmp_product (
	Title VARCHAR(100) CHARACTER SET 'utf8mb4' NOT NULL,
	MainImagePath VARCHAR(1000) CHARACTER SET 'utf8mb4' NULL,
	Name VARCHAR(100) CHARACTER SET 'utf8mb4' NOT NULL,
	IsActive TINYINT(1) NOT NULL,
	Cost DECIMAL(19,4) NOT NULL
);

INSERT INTO Product(Title, Cost, MainImagePath, IsActive, ManufacturerID)
SELECT tmp_product.Title as Title,
		tmp_product.Cost as Cost,
		tmp_product.MainImagePath as MainImagePath,
		tmp_product.IsActive as IsActive,
		Manufacturer.ID as ManufacturerID
FROM tmp_product
INNER JOIN Manufacturer ON tmp_product.Name = Manufacturer.Name
		
		
DROP TABLE `ProductSale`;

REATE TABLE IF NOT EXISTS `Product` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(100) CHARACTER SET 'utf8mb4' NOT NULL,
  `Cost` DECIMAL(19,4) NOT NULL,
  `Description` LONGTEXT CHARACTER SET 'utf8mb4' NULL,
  `MainImagePath` VARCHAR(1000) CHARACTER SET 'utf8mb4' NULL,
  `IsActive` TINYINT(1) NOT NULL,
  `ManufacturerID` INT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_Product_Manufacturer`
    FOREIGN KEY (`ManufacturerID`)
    REFERENCES `Manufacturer` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `ProductSale` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `SaleDate` DATETIME(6) NOT NULL,
  `ProductID` INT NOT NULL,
  `Quantity` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_ProductSale_Product`
    FOREIGN KEY (`ProductID`)
    REFERENCES `Product` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
CREATE TABLE IF NOT EXISTS tmp_sale(
	Title VARCHAR(100) CHARACTER SET 'utf8mb4' NOT NULL,
	Quantity INT NOT NULL,
	SaleDate DATETIME(6) NOT NULL
);

INSERT INTO ProductSale (SaleDate, Quantity, ProductID)
SELECT tmp_sale.SaleDate as SaleDate, tmp_sale.Quantity as Quantity, Product.ID as ProductID
FROM tmp_sale
INNER JOIN Product ON tmp_sale.Title = Product.Title
