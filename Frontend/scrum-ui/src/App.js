import React, { useState } from 'react';
import './App.css';

function App() {
  const [input, setInput] = useState('');
  const [messages, setMessages] = useState([]);
  const [loading, setLoading] = useState(false);

  const handleSend = async () => {
    if (!input) return;
    setLoading(true);
    setMessages([...messages, { role: 'user', text: input }]);

    try {
      const res = await fetch(`http://localhost:8080/api/scrum/chat?message=${encodeURIComponent(input)}`);
      const data = await res.json();
      setMessages(prev => [...prev, { role: 'ai', text: data.reply }]);
    } catch (err) {
      setMessages(prev => [...prev, { role: 'ai', text: "Error: Is the backend running?" }]);
    } finally {
      setLoading(false);
      setInput('');
    }
  };

  return (
      <div className="app-container">
        <header className="header">
          <h1>Scrum AI Assistant</h1>
          <small>Specialized in Technical Debt Reduction</small>
        </header>

        <div className="chat-window">
          {messages.map((m, i) => (
              <div key={i} className={`msg ${m.role}`}>
                <strong>{m.role === 'user' ? 'Me: ' : 'AI: '}</strong> {m.text}
              </div>
          ))}
          {loading && <div className="loading">Analyzing code quality...</div>}
        </div>

        <div className="input-area">
          <input
              value={input}
              onChange={(e) => setInput(e.target.value)}
              onKeyDown={(e) => e.key === 'Enter' && handleSend()}
              placeholder="Ask about SONAR issues or SMTP logic..."
          />
          <button onClick={handleSend} disabled={loading}>Send</button>
        </div>
      </div>
  );
}

export default App;