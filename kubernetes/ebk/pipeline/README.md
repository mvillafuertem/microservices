# Pipeline

GET _ingest/pipeline/

PUT _ingest/pipeline/test-pipeline

body: test-pipeline.json

PUT _ingest/pipeline/_simulate

body: test-pipeline-simulate