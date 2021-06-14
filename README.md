# Electronic-Commerce-Store
Electronic Commerce Store is based on idea to used things buy and sell. Although user can also post ads for new things to sell. Thuis project is built on modern Object Oriented Analysis and Design (OOAD) principles. 
Design includes following classes
Event
Admin
Feedback
User
Guest
OLX
Cart
Order
Reports
Ad
PaymentOptions
EasyPaisa
Card
Paypal
Bank
User class contains the information about the user which can be either the buyer or the seller. It contains the details of the User including his/her contact information and address. The purpose of the user class is to make advertisements, buy products and many other functions to the products and advertisements. User class has a number of responsibilities:
MakeAd(): Through this functionality user will be able to post an advertisement on website by filling in the details.
DeleteAd(int id): User will be able to delete his own advertisement from the website in case the product is already sold or due to some other reasons.
ViewAd(): User will be able to view different advertisements available on the website.
SearchAd(String name): User will be able to browse through the website by searching advertisements by typing the names of the products he/she  wants to see
FilterAdByCategory(String CategoryName): User will be able to filter the advertisements based upon the category. If the user wants to view all the advertisements of a specific category he can view them.
ViewAdDetails(int id):  User will be able to view further details of the advertisement by clicking on it. It can be either his own advertisement or could be posted by some other user.
AddToFavourites(int id): User will be able to add the advertisements he is interested in into his/her favourites by clicking on the add to favourites button and then can view it later. 
RemoveFromFavourites(int id): User will be able to remove the advertisements from favourites by clicking on the remove from favourites button found on the advertisements in the favourites section.
MakeOrder():  User will be able to buy the product he chooses by adding it to the cart and then proceed to checkout from the cart.
DeleteOrder(int id): User will be able to delete the order which he has already confirmed within a day by clicking on the cancel order button.
ReportAd(int id): User will be able to report any advertisement which he/she finds disturbing by clicking on the report button and it will be sent to the system for consideration.
ShareAdvertisements(int id): User will be able to share the advertisement on different social media platforms by selecting the required platform and then clicking on the share button.
ContactUser(int id): User will be able to contact the user from whom he wants to buy the product to get further details about it by pressing the ContactUser button.
EditAd(int id): User will be able to edit the details of his already posted advertisement by clicking on the edit button of the add.
EditProfile(): User will be able to edit his/her own profile in case he wants to change something in the information he has provided.
ViewProfile(): User will be able to view his profile in which all of the information he/she has provided will be shown.
ProvideFeedback(int id): User will be able to provide feedback on a product which he has already bought by writing a comment about it.
ContactSeller(int id): User will be able to contact the seller who is the distributor of the products on the website on a large scale. 

AD Class:
	Ad class contains the information about the ads, which are to be bought by users. Typically an ad contains an id, price, title, pictures, description and information about seller that made the ad. The purpose of Ad class is that a class which will represent the products to the users so that users get to know what kind of attributes that a specific product has.
The main responsibility of the Ad class is:
ApplyForInstallments():
	If user can not pay the whole amount in one go, he/she can apply for installment by calling this function.
Cart Class:
	The main purpose cart is to put items that user selected to buy in one place so that it can proceed to order easily.The cart should contain how many ads a user selected to buy. So, the main responsibilities of a Cart class is as following:
Add_Ad():
	The cart should provide a mechanism to add a product to the car. So by calling this functionality user can add products into the cart.
Remove_Ad():
	Like adding ads to the cart user should also be able to remove an ad from the cart. So, by going through this functionality, user can remove an ad or ads from the cart.
Event Class:
	Event class contains the details of an event such as its start date, end date, place, no of products and the title about event. Purpose of event class is to provide representation to the events and to store details of it.
The main responsibility of Event Class is:
AddDiscount():
	On an event there is usually a discount factor set upon all the products. To mimic this, Add_discount function takes a discount factor and apply it on all the related products.
Payment Options Class:
Its purpose is to make payments to the seller using one of its three child classes, which are easy paisa method, card method, payal. Parent class Payment has identity and balance variables.
Easypaisa Class:
It is one of the child classes of parent class payment. Easypaisa payment is done using CNIC and Easypaisa Account ID of the user.
Card Class:
Its second child class inherited from Payment class. It has card type which can be either a debit card or credit card. Card number, and card daily limit. If order limit exceeds daily limit, this method will not be applicable for user to transact in one day.
Paypal Class:
Its third method of payment inherited from parent class Payment options. It has a unique id and country code through which transaction number will be generated.
Bank Class:
This class will be used to allocate installments plans for eligible users, on the basis of the application they applied to server. User will click a button, and then he fills his details, then the system will proceed and verify his credentials and finally an installment/loan application will be sent to the bank. Later, bank will call them to interview and further processing.
Report Class:
It will have reports about ads by users directed to the admin. User will find add that are not according to community rules, will report them to admin, admin will receive those reports and will verify if reports are genuine. On his analysis, adds will wither get deleted or user gets banned, or both can happen at the same time.
Guest Class:
It will have guest users, by allowing them to visit the website, find adds and share them. They can also get registered. If users don’t want to register, he still can share add, find about product of his need and in the end have to get register to post and add of his own product. It has the following functions
GetRegistered()
It will allow guest user to be a registered user. User will provide his credentials, system will verify them, and user will be notified of completion of his account.
ShareAd()
It will allow guest users to share and add without getting register. It will receive add no, and will share on other platforms to attract more buyers. Also more users to the website.
ViewProducts()
User can view products of his need, can contact seller via his number or email provided. And further they can agree on a deal. This all can be done by user without any registration, the functionality provided in the guest user class. 
