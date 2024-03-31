Project's Title :- amazonTest

Project Description:-
This project aims to automate the testing of the checkout process on Amazon's e-commerce platform to ensure reliability, efficiency, and accuracy. The testing involves creating automated tests for various scenarios encountered during the checkout process, including adding items to the cart, updating shipping information, and removing items from the cart.

Tools and Technologies:

Programming Language:  Java
Automation Tool:  Selenium WebDriver
Testing Framework: Maven build maven dependency tool
Build Tool: Git for version control
Test Scenarios:

Adding Items to Cart:

Objective: Verify that users can add items to their cart from the product detail page.
Steps:
Navigate to the Amazon homepage.
Search for a specific product.
Select a product from the search results.
Click the "Add to Cart" button.
Expected Result: The item is successfully added to the cart, and the cart count is incremented by one.
Updating Shipping Information:

Objective: Confirm that users can update their shipping address during the checkout process.
Steps:
Add items to the cart and proceed to checkout.
Click on the "Change" link under the shipping address.
Enter a new shipping address and save it.
Expected Result: The new shipping address is saved and displayed as the current shipping address for the order.
Removing Items from Cart:

Objective: Test the functionality of removing items from the cart.
Steps:
Add multiple items to the cart.
Navigate to the cart page.
Remove an item from the cart.
Expected Result: The item is successfully removed from the cart, and the cart total is updated accordingly.
Additional Considerations:

Cross-Browser Testing: Tests should run across different browsers to ensure cross-browser compatibility.
Error Handling: Test how the application handles invalid inputs or actions during the checkout process.


