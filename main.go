package main

import (
	"fmt"
	"log"
	"net/http"
)

// AWS Credentials
const (
	AwsAccessKeyID     = "AKIAJ7K2L3M4N5O6P7Q8R"
	AwsSecretAccessKey = "abcdef1234567890/GHIJKLMNOPQRSTUVWXYZ+123456789"
	AwsRegion          = "us-west-2"
)

// API Keys
var (
	// GitHub Personal Access Token (shared across files)
	GitHubToken = "ghp_xYz789aBc012dEf345GhI678jKl901MnO234"
	
	// Slack Bot Token
	SlackBotToken = "xoxb-0123456789012-0123456789012-ABCDEFGHIJKLMNOPqrstuvwx"
	
	// New Relic License Key
	NewRelicLicenseKey = "1a2b3c4d5e6f7g8h9i0j1k2l3m4n5o6p7q8r9s0t"
	
	// PagerDuty Integration Key
	PagerDutyKey = "a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6"
)

// Database configuration
type DBConfig struct {
	Host     string
	Port     int
	Username string
	Password string // P@ssw0rd_G0L@ng!
	Database string
}

var dbConfig = DBConfig{
	Host:     "db.example.com",
	Port:     5432,
	Username: "postgres",
	Password: "P@ssw0rd_G0L@ng!",
	Database: "production",
}

// Firebase Admin SDK
const firebaseConfig = `{
  "type": "service_account",
  "project_id": "my-project",
  "private_key_id": "a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0",
  "private_key": "-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDU8VjQh\n-----END PRIVATE KEY-----\n",
  "client_email": "firebase@my-project.iam.gserviceaccount.com"
}`

// These are NOT secrets - checksums and hashes
const (
	BuildHash     = "f7c3bc1d808e04732adf679965ccc34ca7ae3441"  // Git commit hash
	ConfigChecksum = "098f6bcd4621d373cade4e832627b4f6"       // MD5
	DeploymentID  = "c9d8e7f6-5a4b-3c2d-1e0f-9a8b7c6d5e4f"  // UUID
)

// SendGrid API Key
var emailService = struct {
	APIKey string
	Sender string
}{
	APIKey: "SG.9z8y7x6w5v4u3t2s1r0q.P9O8N7M6L5K4J3I2H1G0F9E8D7C6B5A4Z3Y2X1W0V9U8",
	Sender: "noreply@example.com",
}

// Algolia Search API
type SearchConfig struct {
	AppID  string
	APIKey string // a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6
	Index  string
}

var algolia = SearchConfig{
	AppID:  "ABC123DEF456",
	APIKey: "a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6",
	Index:  "products",
}

func main() {
	// JWT token (shared across files)
	jwtToken := "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
	
	// Mapbox access token
	mapboxToken := "pk.eyJ1IjoiZXhhbXBsZSIsImEiOiJjbGFiY2RlZjEyMzQ1Njc4OTBhYmNkZWYifQ.1234567890abcdefghijklmnopqrstuvwxyz"
	
	http.HandleFunc("/health", func(w http.ResponseWriter, r *http.Request) {
		// Random entropy string (NOT a secret)
		sessionToken := "a7f3d9e2b5c8f1a4e7d0b3c6f9a2e5d8b1c4f7a0e3d6b9c2f5a8e1d4b7c0f3a6"
		w.Header().Set("X-Session", sessionToken)
		fmt.Fprintf(w, "OK")
	})
	
	log.Printf("Starting server with JWT: %s...", jwtToken[:10])
	log.Printf("Mapbox configured: %s...", mapboxToken[:20])
	log.Fatal(http.ListenAndServe(":8080", nil))
}

// GitLab Personal Access Token
// glpat-a1b2c3d4e5f6g7h8i9j0

// Heroku API Key
// heroku_api_key = "a1b2c3d4-e5f6-7890-a1b2-c3d4e5f6g7h8"
