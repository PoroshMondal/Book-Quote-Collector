# 📚 Book Quote Collector – Android App

An Android application built to collect, manage, and organize memorable quotes from books.
Users can add quotes with relevant details, mark favorites, search, filter, and toggle between light and dark themes. 
Built with clean architecture and room database for a smooth and responsive experience.

---

## 📸 Screenshots

> *app screenshots `./screenshots/home_screen.png`*

---

## 📘 Features

- Add quotes with text, author, book title, and optional category/tag
- View list of saved quotes
- Quote detail view with edit/delete/bookmark
- Swipe-to-delete with undo (Snackbar)
- Search quotes by text, author, or book
- Filter quotes by category/tag
- Mark/unmark as favorites
- View favorite quotes separately
- Light/Dark mode toggle
- Local data persistence with Room or DataStore

---

## 🛠️ Tech Stack

- **Language:** Java
- **Architecture:** MVVM 
- **UI:** XML Layouts
- **Persistence:** Room 
- **Async Handling:** LiveData 
- **Minimum SDK:** 21

---

## 📦 How to Build & Run

1. Clone the repository:
   ```bash
   git clone https://github.com/PoroshMondal/Book-Quote-Collector.git
   cd book-quote-collector
   ```

2. Open the project in **Android Studio**

3. Build the project and run on an emulator or physical device (min SDK 21)

---

## 📐 Architecture

This project follows the **MVVM architecture pattern**, using:
- Repository pattern for data abstraction
- Room for local storage
- ViewModel + LiveData for UI state management
- Clean and modular code structure for maintainability

---

## 📁 APK Download

You can download the latest APK [here](#)

---

## ✅ Bonus Features (Optional)
Later Plan to implement these features - 
- Export all saved quotes as text or JSON
- Daily notification with a random quote
- Unit/UI tests for ViewModel and DAO

---

