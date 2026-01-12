# Bunch of leaked secrets
For leaked secrets detection testing

⚠️ **WARNING: This repository contains FAKE secrets for testing purposes only. None of these tokens, API keys, or credentials are real or functional.**

## Purpose

This repository is designed to test and validate secrets detection tools. It contains:

- Hardcoded fake API keys, tokens, and passwords across multiple file types
- Realistic patterns matching popular services (AWS, Google Cloud, Stripe, OpenAI, GitHub, etc.)
- Shared secrets across files for deduplication testing
- High-entropy strings that are NOT secrets (to test false positive handling)
- Various secret formats: variables, comments, inline strings, environment files
- Clean files with no secrets for baseline testing

## Secret Types Included

### Real Service Patterns (Fake Values)
- AWS Access Keys
- Google Cloud API Keys
- Stripe API Keys
- OpenAI API Keys
- GitHub Personal Access Tokens
- Slack Webhooks
- SendGrid API Keys
- Twilio Auth Tokens
- JWT Secrets
- Database Passwords
- Private Keys (RSA)

### Shared Secrets
Some secrets appear in multiple files to test deduplication capabilities:
- `sk_live_51abc123def456ghi789jkl012mno345`
- `ghp_xYz789aBc012dEf345GhI678jKl901MnO234`
- `super_secret_jwt_key_2024`

### False Positives (Not Secrets)
- SHA-256 hashes
- MD5 checksums
- Base64 encoded data
- UUIDs
- Random hex strings

## Testing Your Tool

1. Clone this repository
2. Run your secrets detection tool against it
3. Verify it detects the actual secrets
4. Check that it properly deduplicates shared secrets
5. Ensure it doesn't flag the high-entropy non-secrets
6. Confirm `no_secrets.java` returns clean (no secrets)

## Expected Results

- **Total Secret Instances**: ~40-50 depending on detection granularity
- **Unique Secrets**: ~35-40 after deduplication
- **Clean Files**: 1 (no_secrets.java)

## Disclaimer

All secrets in this repository are **completely fake** and have been randomly generated. They follow the format patterns of real services but are not valid credentials. Do not attempt to use them.

## License

Public Domain - Use freely for testing purposes.
