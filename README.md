# 🚀 Automated Scrum Assistant (AI-Powered RAG System)

## 📌 Overview

Automated Scrum Assistant is a full-stack AI application that helps Agile teams generate **sprint summaries** and **user stories** from sprint notes and requirements using a **Retrieval-Augmented Generation (RAG)** architecture.

---

## 🧠 Key Features

* 📄 Upload sprint notes or requirements
* 🧠 Generate sprint summaries automatically
* ✍️ Convert requirements into structured Scrum user stories
* 🔍 Context-aware responses using semantic search (not keyword-based)
* 💸 Fully local AI setup (no paid APIs required)

---

## 🏗️ Architecture

### 🔹 Frontend

* React (UI for input & results)

### 🔹 Backend

* FastAPI (REST APIs)
* Python 3.11

### 🔹 AI / ML Layer

* Sentence-Transformers (`all-MiniLM-L6-v2`) → embeddings
* ChromaDB → vector database
* Ollama + Mistral → local LLM for generation

---

## 🔄 How It Works (RAG Flow)

1. Sprint notes are converted into embeddings
2. Stored in ChromaDB (vector database)
3. User query is converted into embedding
4. Relevant context is retrieved (semantic search)
5. Context is passed to Mistral LLM
6. LLM generates summary or user stories

---

## ⚙️ Setup Instructions

### 1️⃣ Backend Setup

```bash
cd backend
python3 -m venv venv
source venv/bin/activate
pip install -r requirements.txt
python -m uvicorn app.main:app --reload
```

### 2️⃣ Frontend Setup

```bash
cd frontend/scrum-ui
npm install
npm start
```

---

## 🤖 Local LLM Setup (Important)

Install Ollama:

```bash
brew install ollama
```

Pull model:

```bash
ollama pull mistral
```

Run model:

```bash
ollama run mistral
```

---

## 📡 API Endpoints

| Endpoint        | Method | Description             |
| --------------- | ------ | ----------------------- |
| `/api/document` | POST   | Store sprint notes      |
| `/api/summary`  | GET    | Generate sprint summary |
| `/api/stories`  | POST   | Generate user stories   |

---

## 📸 Demo

(Add screenshots of your UI here)

---

## 💡 Future Improvements

* PDF / DOC file upload support
* Acceptance criteria generation
* Streaming responses
* Deployment using Docker / AWS

---

## 👩‍💻 Author

Srilahari Sivanvitha Nori
