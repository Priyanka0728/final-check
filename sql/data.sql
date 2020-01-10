-- Include table data insertion, updation, deletion and select scripts

-- ---------------------------------------------------------------------------
-- ----- Adding Menu Items in Menu Table
-- ---------------------------------------------------------------------------
INSERT INTO movie_item
VALUES
(1, 'Avatar', 2787965085, 'Yes', '2017-03-15','Super Fictions', 'Yes'),
(2, 'The Avengers', 1518812988, 'Yes', '2017-12-23','Superhero', 'No'),
(3, 'Titanic', 2187463944, 'Yes', '2017-08-21', 'Romance','No'),
(4, 'Jurassic World', 1671713208, 'No', '2017-07-02','Science Fiction','Yes'),
(5, 'Avengers End Game', 2750760348, 'yes','2022-11-02','Sueprhero','Yes');

-- ---------------------------------------------------------------------------
-- ----- Displaying  Menu Table
-- ---------------------------------------------------------------------------
select * from movie_item;

-- ----------------------------------------------------------------------------
-- ----- Updating Movie Items in Movie item table
-- ----------------------------------------------------------------------------


update movie_item
set mov_title='Starwar',mov_gross=1271713409
where mov_id=1;

-- ---------------------------------------------------------------------------
-- ----- Displaying Customer list in Movir item Table
-- ---------------------------------------------------------------------------

    
select mov_title, mov_gross,mov_gence,mov_has_teaser 
from movie_item
where mov_active='Yes'
and mov_date_of_launch <= current_date();


-- ---------------------------------------------------------------------------
-- ----- Setting User Name and Id
-- ---------------------------------------------------------------------------
 
 INSERT INTO USER VALUES(1,'Pinky143'),
 (2,'Jaanu143');
 
 select * from user;
 
 
 
-- ---------------------------------------------------------------------------
-- ----- Add to favorites
-- ---------------------------------------------------------------------------

INSERT INTO favorites (ft_us_id,ft_pr_id) VALUES(2,1),
(2,2),
(2,5),
(2,1),
(1,1),
(1,4);

select * from favorites;
-- --------------------------------------------------------------
-- ----- View favorites
-- --------------------------------------------------------------
select mov_title,mov_gross,mov_gence
from movie_item
inner join favorites  
on ft_pr_id=mov_id
where ft_us_id=2;


-- ----------------------------------------------------------------
-- ----- Delete Favorites
-- ----------------------------------------------------------------
delete from favorites
where ft_us_id=2
and ft_pr_id=1
limit 1;

-- -----------------------------------------------------------------
-- ---------------view  favorites ----------------------------
-- -----------------------------------------------------------------

select mov_title,mov_gross,mov_gence
from movie_item
inner join favorites  
on ft_pr_id=mov_id
where ft_us_id=2;


-- -----------------------------------------------------------------
-- Show no of favorites----------------------------------------------------
-- -----------------------------------------------------------------
select count(mov_title) as No_of_favorites from movie_item
inner join favorites on ft_pr_id=mov_id
where ft_us_id=2; 











