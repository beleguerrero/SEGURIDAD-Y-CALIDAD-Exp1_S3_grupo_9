module.exports = {
  darkMode: "class",
  content: [
    "./src/main/resources/templates/**/*.html",
    "./src/main/resources/static/**/*.js"
  ],
  theme: {
    extend: {
      colors: {
        "on-tertiary-fixed": "#002113",
        "error": "#ba1a1a",
        "secondary": "#00687a",
        "outline": "#777587",
        "primary": "#3525cd",
        "on-tertiary-container": "#67f4b7",
        "secondary-container": "#57dffe",
        "outline-variant": "#c7c4d8",
        "on-background": "#131b2e",
        "surface-tint": "#4d44e3",
        "on-primary-fixed-variant": "#3323cc",
        "tertiary-container": "#006e4b",
        "on-error-container": "#93000a",
        "background": "#faf8ff",
        "secondary-fixed-dim": "#4cd7f6",
        "on-primary-fixed": "#0f0069",
        "surface-container": "#eaedff",
        "inverse-primary": "#c3c0ff",
        "surface-container-low": "#f2f3ff",
        "surface-container-lowest": "#ffffff",
        "on-surface-variant": "#464555",
        "inverse-surface": "#283044",
        "on-primary": "#ffffff",
        "secondary-fixed": "#acedff",
        "on-primary-container": "#dad7ff",
        "surface-container-high": "#e2e7ff",
        "on-secondary": "#ffffff",
        "surface-dim": "#d2d9f4",
        "surface-container-highest": "#dae2fd",
        "on-secondary-fixed": "#001f26",
        "primary-fixed-dim": "#c3c0ff",
        "on-secondary-container": "#006172",
        "inverse-on-surface": "#eef0ff",
        "primary-fixed": "#e2dfff",
        "surface-variant": "#dae2fd",
        "surface": "#faf8ff",
        "on-secondary-fixed-variant": "#004e5c",
        "error-container": "#ffdad6",
        "on-tertiary-fixed-variant": "#005236",
        "surface-bright": "#faf8ff",
        "on-surface": "#131b2e",
        "tertiary-fixed-dim": "#4edea3",
        "on-tertiary": "#ffffff",
        "on-error": "#ffffff",
        "primary-container": "#4f46e5",
        "tertiary": "#005338",
        "tertiary-fixed": "#6ffbbe"
      },
      borderRadius: {
        DEFAULT: "0.25rem",
        lg: "0.5rem",
        xl: "0.75rem",
        full: "9999px"
      },
      spacing: {
        "space-sm": "0.5rem",
        "space-xs": "0.25rem",
        "space-lg": "1.5rem",
        "space-md": "1rem",
        margin: "2rem",
        gutter: "1.5rem",
        "margin-mobile": "1rem",
        "gutter-mobile": "0.75rem",
        "space-xl": "2.5rem"
      },
      fontFamily: {
        "body-sm": ["Plus Jakarta Sans"],
        "headline-lg": ["Space Grotesk"],
        "label-md": ["Space Grotesk"],
        "label-sm": ["Space Grotesk"],
        "headline-lg-mobile": ["Space Grotesk"],
        "headline-md": ["Space Grotesk"],
        "display-hero-mobile": ["Space Grotesk"],
        "display-hero": ["Space Grotesk"],
        "stat-numeric": ["Space Grotesk"],
        "body-lg": ["Plus Jakarta Sans"],
        "headline-sm": ["Space Grotesk"],
        "body-md": ["Plus Jakarta Sans"]
      },
      fontSize: {
        "body-sm": ["12px", {
          lineHeight: "18px",
          fontWeight: "500"
        }],
        "headline-lg": ["32px", {
          lineHeight: "40px",
          letterSpacing: "-0.02em",
          fontWeight: "700"
        }],
        "label-md": ["13px", {
          lineHeight: "16px",
          letterSpacing: "0.04em",
          fontWeight: "600"
        }],
        "label-sm": ["11px", {
          lineHeight: "14px",
          letterSpacing: "0.06em",
          fontWeight: "700"
        }],
        "headline-lg-mobile": ["26px", {
          lineHeight: "32px",
          letterSpacing: "-0.01em",
          fontWeight: "700"
        }],
        "headline-md": ["24px", {
          lineHeight: "32px",
          letterSpacing: "-0.01em",
          fontWeight: "600"
        }],
        "display-hero-mobile": ["36px", {
          lineHeight: "44px",
          letterSpacing: "-0.02em",
          fontWeight: "700"
        }],
        "display-hero": ["56px", {
          lineHeight: "64px",
          letterSpacing: "-0.03em",
          fontWeight: "700"
        }],
        "stat-numeric": ["28px", {
          lineHeight: "32px",
          letterSpacing: "-0.02em",
          fontWeight: "700"
        }],
        "body-lg": ["16px", {
          lineHeight: "26px",
          fontWeight: "400"
        }],
        "headline-sm": ["18px", {
          lineHeight: "24px",
          letterSpacing: "0em",
          fontWeight: "600"
        }],
        "body-md": ["14px", {
          lineHeight: "22px",
          fontWeight: "400"
        }]
      }
    }
  },
  plugins: [
    require('@tailwindcss/forms'),
    require('@tailwindcss/container-queries')
  ]
};