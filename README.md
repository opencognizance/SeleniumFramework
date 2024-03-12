# SeleniumFramework

# Selenium Framework with Page Object Model (POM) and Design Patterns

This repository contains a Selenium framework for automated web testing, utilizing design patterns such as the Page Object Model (POM), Facade Design Pattern, and Singleton Pattern. These design patterns help in organizing and maintaining scalable, modular, and efficient automation scripts.

## Features

- **Page Object Model (POM)**: This design pattern separates web pages into individual classes, allowing easy maintenance and scalability of tests. Each page is represented by a class containing the elements and methods relevant to that page.

- **Facade Design Pattern**: The Facade pattern provides a unified interface to a set of interfaces in a subsystem. In the context of Selenium testing, it can simplify complex operations by providing a higher-level interface to interact with web elements and perform actions.

- **Singleton Pattern**: This pattern ensures that a class has only one instance and provides a global point of access to it. In the context of this framework, the WebDriver instance is managed using the Singleton pattern to ensure consistent browser sessions throughout the tests.

## Setup

1. **Clone the Repository**: 
