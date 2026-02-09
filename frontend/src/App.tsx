import './App.css'
import { Routes, Route, Navigate } from 'react-router-dom';
import { Toaster } from 'react-hot-toast';
import { AuthProvider } from "./providers/AuthContext.tsx";
import { ProtectedRoute } from "./providers/ProtectedRoute.tsx";
import HomePage from "./presentation/pages/HomePage.tsx";
import CreationDestinationPage from "./presentation/pages/CreationDestinationPage.tsx";
import NotFound from "./presentation/pages/NotFound.tsx";
import LoginPage from "./presentation/pages/LoginPage.tsx";

function App() {
      return (
          <AuthProvider>
              <Toaster position="top-center" />

              <Routes>
                  <Route path="/auth" element={<LoginPage />} />

                  <Route path="/dashboard/me" element={
                      <ProtectedRoute>
                        <HomePage />
                      </ProtectedRoute>
                  }/>
                  <Route path="/destinations/form" element={
                      <ProtectedRoute>
                        <CreationDestinationPage />
                      </ProtectedRoute>
                  }/>

                  <Route path="/" element={<Navigate to="/dashboard/me" replace />} />
                  <Route path="*" element={<NotFound />} />
              </Routes>
          </AuthProvider>
      )
}

export default App
